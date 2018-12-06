/*package com.wp.hny.account.api.dto;


import java.awt.AlphaComposite;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics2D;  
import java.awt.image.BufferedImage;  
import java.io.OutputStream;  
import java.util.Random;  
*//**
 * Gif验证码类
 * @author swiftwen
 * @date 2018年12月5日 下午1:49:27
 *//*
public class GifCaptcha extends Captcha {
	public GifCaptcha() {
	}

	public GifCaptcha(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public GifCaptcha(int width, int height, int alpha) {
		this(width, height);
	}

	public GifCaptcha(int width, int height, int alpha, Font font) {
		this(width, height, alpha);
		this.font = font;
	}

	@Override
	public void out(OutputStream os) {
		try {
			//是一个用来生成 GIF 图片格式的 Java 图形处理类库
			GifEncoder gifEncoder = new GifEncoder();
			//生成字符
			gifEncoder.start(os);
			//品质
			gifEncoder.setQuality(180);
			//推迟
			gifEncoder.setDelay(200);
			//重复
			gifEncoder.setRepeat(0);
			BufferedImage frame;
			char[] rands = this.getYanzhenmastr().toCharArray();
			Color fontcolor[] = new Color[rands.length];
			for (int i = 0; i < rands.length; i++) {
				fontcolor[i] = new Color(20 + Randoms.num(110),
						20 + Randoms.num(110), 20 + Randoms.num(110));
			}
			int start = 8;
			for (int i = 0; i < rands.length; i++) {
				frame = graphicsImage(fontcolor, rands, i,start);
				//添加帧图
				gifEncoder.addFrame(frame);
				start = start + 8;
				//输出
				frame.flush();
			}
			gifEncoder.finish();
		} finally {
			Streams.close(os);
		}

	}

	*//**
	 * 画随机码图
	 * 
	 * @param fontcolor
	 *            随机字体颜色
	 * @param strs
	 *            字符数组
	 * @param flag
	 *            透明度使用
	 * @return BufferedImage
	 *//*
	private BufferedImage graphicsImage(Color[] fontcolor, char[] strs, int flag,int start) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Random r = new Random();
		// 或得图形上下文
		// Graphics2D g2d=image.createGraphics();
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		// 利用指定颜色填充背景
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(getRandColor(120, 200));
		for (int i = 0; i < 200; i++) {
			int x = r.nextInt(width - 1);
			int y = r.nextInt(height - 1);
			int xl = r.nextInt(6) + 1;
			int yl = r.nextInt(12) + 1;
			g2d.drawLine(x, y, x + xl, y + yl);
		}
		for (int i = 0; i < 100; i++) {
			int x = r.nextInt(width - 1);
			int y = r.nextInt(height - 1);
			int xl = r.nextInt(12) + 1;
			int yl = r.nextInt(6) + 1;
			g2d.drawLine(x, y, x - xl, y - yl);
		} 
		int degree = r.nextInt(20);//旋转度数 最好小于45度    
		if (flag % 2 == 1){
			degree = degree * (-1);  
		}
		g2d.rotate(Math.toRadians(degree), start, 21);  

		//类实现一些基本的 alpha 合成规则,将源色与目标色组合,在图形和图像中实现混合和透明效果。
		AlphaComposite ac3;
		//得到写入所需的宽和高
		int h = height - ((height - font.getSize()) >> 1);
		int w = width / strs.length;
		//设置字体
		g2d.setFont(font);
		//画圈和字符
		for (int i = 0; i < strs.length; i++) {
			ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					getAlpha(flag, i));
			g2d.setComposite(ac3);
			g2d.setColor(fontcolor[i]);
			//画圈
			g2d.drawOval(Randoms.num(width), Randoms.num(height),
					5 + Randoms.num(10), 5 + Randoms.num(10));
			//画字
			g2d.drawString(strs[i] + "",
					(width - (strs.length - i) * w) + (w - font.getSize()) + 1, h - 4);
		}
		g2d.rotate(-Math.toRadians(degree), start, 21);//旋转之后，必须旋转回来  
		g2d.dispose();
		return image;
	}

	*//**
	 * 获取透明度,从0到1,自动计算步长
	 * 
	 * @return float 透明度
	 *//*
	private float getAlpha(int i, int j) {
		int num = i + j;
		float r = (float) 1 / alpha, s = (alpha + 1) * r;
		float value = num > 5 ? (num * r - s) : num * r;
		if(value > 1.0f){
			value = 1.0f;
		}
		return value;
	}

}

*/