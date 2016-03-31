package com.google.everloser12.homework2;


import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;




/**
 * управляющий класс, содержит коллекцию с данными, получаемыми после парсинга
 * содержит методы для скачивания файлов, парсинга, сортировок, рассчета
 * зарплаты
 * 
 * @author al-ev
 *
 */
public class Manage
	{

		private static Manage instance = new Manage();
		private static Root root = null;

		private Manage()
			{
			}

		public static Manage getInstance()
			{
				return instance;
			}

		public static Root getRoot()
			{
				return root;
			}

		public static void setRoot(Root root)
			{
				Manage.root = root;
			}

		/**
		 * метод для скачивания файла с помощью HttpURLConnection
		 * 
		 * @param string
		 *            - URL адрес скачиваемого файла в виде строки
		 * @param filez
		 *            - название сохраняемого файла в виде строки
		 * @return метод возвращает объект класса File
		 */
		public static File download(String string, String filez)
			{
				InputStream inpStrm = null;
				FileOutputStream otpStrm = null;
				Log.d("MoiMoi", "make File");
				File file = new File(filez);

				try
					{
						URL url = new URL(string);
						HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
						int responseCode = httpURLConnection.getResponseCode();
						if (responseCode == HttpURLConnection.HTTP_OK)
							{
								Log.d("MoiMoi", "connect" + responseCode);

								inpStrm = httpURLConnection.getInputStream();

								otpStrm = new FileOutputStream(file);
								int byteRead = -1;
								byte[] buffer = new byte[512];
								while ((byteRead = inpStrm.read(buffer)) != -1)
									{
										Log.d("MoiMoi", "write File");
										otpStrm.write(buffer, 0, byteRead);
									}
							} else
							{
								return null;
							}
					} catch (Exception e)
					{
						Log.d("MoiMoi", "connection" + e.getMessage());

					} finally
					{
						if (inpStrm != null)
							{
								try
									{
										inpStrm.close();
									} catch (Exception e)
									{
										Log.d("MoiMoi", "connection" + e.getMessage());
									}
								try
									{
										otpStrm.close();
									} catch (Exception e)
									{
										Log.d("MoiMoi", "connection" + e.getMessage());
									}
							}
					}
				Log.d("MoiMoi", "hotim vozvernut fail");
				return file;
			}

		public static void parseXML()
			{
				Parse parse = new ParseXMLbySAX();
				root = parse.getResult();
			}


		public static void parseJSONSimpl()
			{
				Parse parse = new ParseJSONSimple();
				root = parse.getResult();
			}


//		public static void sortName()
//			{
//				List<Employees> e = root.getEmployees();
//				Collections.sort(e);
//				root.setEmployees(e);
//			}
//
//		public static void sortSalary()
//			{
//				List<Employees> e = root.getEmployees();
//				Comparator<Employees> comporator = new Comparator<Employees>()
//					{
//						@Override
//						public int compare(Employees o1, Employees o2)
//							{
//								int result = 0;
//								if (o1.getRate() < o2.getRate())
//									result = -1;
//								if (o1.getRate() > o2.getRate())
//									result = 1;
//								// int result =
//								// ((Double)(o1.getRate())).compareTo((Double)(o2.getRate()));
//								return result;
//							}
//					};
//				Collections.sort(e, comporator);
//				root.setEmployees(e);
//			}
	}
