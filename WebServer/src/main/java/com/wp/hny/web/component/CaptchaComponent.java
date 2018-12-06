package com.wp.hny.web.component;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wp.hny.base.util.RedisClient;


/**
 * 图片验证码
 * @author swiftwen
 * @date 2018年12月5日 下午2:03:49
 */
//@Component
public class CaptchaComponent {
    
    @Autowired
    private RedisClient redisClient;
    
    // 图片的宽度
    private static final int CAPTCHA_WIDTH = 90;   
    // 图片的高度
    private static final int CAPTCHA_HEIGHT = 20;    
    // 验证码的个数
    private static final int CAPTCHA_CODECOUNT = 4;  
    
    private static final int XX = 15; 
    private static final int CAPTCHA_FONT_HEIGHT = 18; 
    private static final int CAPTCHA_CODE_Y = 16; 
    private static final char[] codeSequence = { 
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 
            'O', 'P', 'Q', 'R', 'S', 'T', 
            'U', 'V', 'W', 'X', 'Y', 'Z', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }; 
    
    // 过期时间为60秒
    private static final long EXPIRE_MINUTES = 60;
    
    public void genCaptcha(HttpServletRequest req, HttpServletResponse resp){ 
 
        // 定义图像 Buffer  
        BufferedImage buffImg = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB); 
        // 创建一个绘制图像的对象
        Graphics2D g = buffImg.createGraphics();
        // 创建一个随机数生成器类  
        Random random = new Random(); 
        // 将图像填充为白色  
        g.setColor(Color.WHITE); 
        g.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT); 
        // 设置字体
        g.setFont(new Font("Fixedsys", Font.BOLD, CAPTCHA_FONT_HEIGHT)); 
        // 设置字体边缘光滑
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        // 画边框  
        g.setColor(Color.BLACK); 
        g.drawRect(0, 0, CAPTCHA_WIDTH - 1, CAPTCHA_HEIGHT - 1); 
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。  
        g.setColor(Color.BLACK); 
        for (int i = 0; i < 40; i++) { 
            int x = random.nextInt(CAPTCHA_WIDTH); 
            int y = random.nextInt(CAPTCHA_HEIGHT); 
            int xl = random.nextInt(12); 
            int yl = random.nextInt(12); 
            g.drawLine(x, y, x + xl, y + yl); 
        } 
 
        // 保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer randomCode = new StringBuffer(); 
        int red = 0, green = 0, blue = 0; 
        // 随机产生验证码  
        for (int i = 0; i < CAPTCHA_CODECOUNT; i++) { 
            // 得到随机产生的验证码数字
            String code = String.valueOf(codeSequence[random.nextInt(36)]); 
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同  
            red = random.nextInt(255); 
            green = random.nextInt(255); 
            blue = random.nextInt(255); 
            // 用随机产生的颜色将验证码绘制到图像中  
            g.setColor(new Color(red, green, blue)); 
            g.drawString(code, (i + 1) * XX, CAPTCHA_CODE_Y); 
            // 将产生的随机数组合在一起
            randomCode.append(code); 
        } 

        // 禁止图像缓存
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        // 将图像输出到Servlet输出流中  
        ServletOutputStream sos = null;
        try {
            sos = resp.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);   
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                sos.close();
                g.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //TODO redis insert
        redisClient.set("randomCode", randomCode.toString(), 5*60);//5分钟过期
       // this.redisBaseDao.addValue(token, randomCode.toString());
        //this.redisBaseDao.expire(token, EXPIRE_MINUTES, TimeUnit.MINUTES);
    }
}
