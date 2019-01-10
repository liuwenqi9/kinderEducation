package com.muji.zh.student.util;

import java.io.*;

import java.net.HttpURLConnection;

import java.net.URL;







import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("restriction")

public class Base64Utils {



	public static void main(String[] args) throws Exception {


//
//		//本地图片地址
//
//		String url = "C:\\ss\\1815925402.png";
//
//		//在线图片地址
//
//		String string = "http://bpic.588ku.com//element_origin_min_pic/17/03/03/7bf4480888f35addcf2ce942701c728a.jpg";
//
//
//
//		String str = Base64Utils.ImageToBase64ByLocal(url);
//
//
//
//		String ste = Base64Utils.ImageToBase64ByOnline(string);
//
//
//
//		System.out.println(str);
//
//
//
//		Base64Utils.Base64ToImage(str,"C:\\ss\\1815925622.png");
//
//
//
//		Base64Utils.Base64ToImage(ste, "C:\\ss\\1815925621.png");


		String s="iVBORw0KGgoAAAANSUhEUgAAAHsAAAA8CAIAAADJ+FL8AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAADUElEQVR4nO1cwW6jMBCdsaGRctyVVj13D/2a7v//QLVSteccktizBycUzDgBYwYDfpcSahvzeB7PjA348+0DdgNEbI6J6HYAQIOrN7WiUU2sPxPa1Cx4uT6/0zuWKeMzoWEQETt6D5RvizqVCFSSVgqGw9d4/0k+sFwTC8sjog/Ju100Lo3CuDQK49KontqpUYYsB2OdOYrGpVFNDaFSgIjUfXDcvB3BsSLMQEUtUzA9hIXB8Zsr9vr6i4g+P/+C1i7ccIVytk3DLSfL55Ixp7X2/f3NWvv19e9yuQAAEb28vBhjFuzV3MAfv/8spXFjTF3XRHQ6nY7Ho9b6fD4bY7TWOc/A69B4/9pEpJSyxiBAVVXX65WIEFGpjU/mHcbnVpY3mJRSl/NZIR4OB2uttdYV8NJM6wV7F0sKyhgDiKAUEVlrnca11gt2SQALD+G6rm8uCpGTdpK5JGcs6as0JtvZ9D3QDUOi/CTwrtI26KF/bRUbdwwyRGFcGoVxaRTGpVEYl0ZhXBod77C9N6PtGrNlxoLNl63XF4zexyIXAbkubiZnEg3GqjTpJPHO7AKTNB6XKd6GVYnGI8YTJjp2yGwIfH684bowlRyMxhs7njCTF9rUukMwjO8hZZoCkboZPXPGKTRca616jx6oJeaURmFcGs937M8M5nKhiWTiRpFHnRC866JxaezrzasQ5nDOQqMmfm9t0yIFzq8I87nDfTYq/9xgwoiNkmhMEwG0o6S44GCUXSYAmkcmyPU93qoEE1IlfgIAp0juvNB+lcwh6T/Ea5xfGCLANVpywXGZID/+/UkBl24MMJ7tYBLuVvEO3bicqWHmefIry0Nb7L/as85pcz6Z9/nwNB556SEGI3YLQFStbB5834Gu2veUwNKmV0usCLiT0fmW6DWDfsVixwEAbOB8KK4eCAIC6qxlQmEc4OEomjhk08acawS7ykoQNBnUO4Axbi7Sd1H35g2I7VeZjrHfyhnVs6dGI86q8FF+VFNbw0yMO0vuYRrjmThhXDeCHxvrKo+8v94v5BoaftfUzWe5mRNhHe9PprJfHF2o/TL33TWAjErZZu8bqrrWj5k2ilVJif6re32Udc4niPYOQhUL488xkHT/q5UB5+o/hpszfrbTjY0AAAAASUVORK5CYII=";
		String path="D:\\2";
		String filenmae="D:\\2\\2.png";
		//Base64Utils.Base64ToImage(s,path,filenmae);
	}



	/**

	 * 本地图片转换成base64字符串

	 * @param imgFile	图片本地路径

	 * @return

	 *

	 * @author ZHANGJL

	 * @dateTime 2018-02-23 14:40:46

	 */

	public static String ImageToBase64ByLocal(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理





		InputStream in = null;

		byte[] data = null;



		// 读取图片字节数组

		try {

			in = new FileInputStream(imgFile);



			data = new byte[in.available()];

			in.read(data);

			in.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		// 对字节数组Base64编码

		BASE64Encoder encoder = new BASE64Encoder();



		return encoder.encode(data);// 返回Base64编码过的字节数组字符串

	}







	/**

	 * 在线图片转换成base64字符串

	 *

	 * @param imgURL	图片线上路径

	 * @return

	 *

	 * @author ZHANGJL

	 * @dateTime 2018-02-23 14:43:18

	 */

	public static String ImageToBase64ByOnline(String imgURL) {

		ByteArrayOutputStream data = new ByteArrayOutputStream();

		try {

			// 创建URL

			URL url = new URL(imgURL);

			byte[] by = new byte[1024];

			// 创建链接

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.setConnectTimeout(5000);

			InputStream is = conn.getInputStream();

			// 将内容读取内存中

			int len = -1;

			while ((len = is.read(by)) != -1) {

				data.write(by, 0, len);

			}

			// 关闭流

			is.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		// 对字节数组Base64编码

		BASE64Encoder encoder = new BASE64Encoder();

		return encoder.encode(data.toByteArray());

	}





	/**

	 * base64字符串转换成图片

	 * @param imgStr		base64字符串

	 * @param imgFilePath	图片存放路径

	 * @return

	 *

	 * @author ZHANGJL

	 * @dateTime 2018-02-23 14:42:17

	 */

	public static boolean Base64ToImage(String imgStr, String imgFilePath, String filename, HttpServletRequest request) { // 对字节数组字符串进行Base64解码并生成图片

		System.out.println(imgFilePath);



   		File file =new File(request.getRealPath("/")+imgFilePath);

//如果文件夹不存在则创建

		if  (!file .exists()  && !file .isDirectory())

		{

			System.out.println("//不存在");

			file .mkdir();

		} else

		{

			System.out.println("//目录存在");

		}




		if (StringUtil.isEmpty(imgStr)) // 图像数据为空

			return false;



		BASE64Decoder decoder = new BASE64Decoder();

		try {

			// Base64解码

			byte[] b = decoder.decodeBuffer(imgStr);

			for (int i = 0; i < b.length; ++i) {

				if (b[i] < 0) {// 调整异常数据

					b[i] += 256;

				}

			}



			OutputStream out = new FileOutputStream(imgFilePath+filename);

			out.write(b);

			out.flush();

			out.close();



			return true;

		} catch (Exception e) {

			return false;

		}



	}






}
