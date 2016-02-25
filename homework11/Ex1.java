package homework11;

import java.util.Scanner;

/**
 * Написать простой калькулятор в консоли, который будет уметь складывать,
 * отнимать, умножать и делить числа, и выводить результат. Вам нужно
 * модернизировать калькулятор с использованием своих исключений. Вы должны
 * сделать как минимум 2 исключения - одно например которое ловит ошибки
 * некорректного ввода, а другое ошибки при расчете + добавьте в свое исключение
 * метод getRussianMessage что бы можно было получить описание ошибки на
 * русском.
 * 
 * @version
 * @author
 */
public class Ex1
	{

		public static void main(String[] args)
			{
				Scanner go = new Scanner(System.in);
				Double res = (double) 0;
				Double res2 = (double) 0;
				String[] toParse = null;
				boolean d = true;
				boolean exit = false;
				do
					{
						do
							{
								System.out.print("\n\nВведите желаемую операцию вычисления в виде\n<ЧИСЛО1><ПРОБЕЛ>"
										+ "<ЧИСЛО2><ПРОБЕЛ><ОПЕРАЦИЯ>\n" + "Пример: 5 18 *\n"
										+ "или 45.0 3.25 +\nили n для выхода");
								String all = go.nextLine();
								all = all.trim();

								toParse = all.split("\\s");
								if (toParse.length == 1 && toParse[0].equalsIgnoreCase("n"))
									{
										exit = true;
										break;
									}
								try
									{
										test(toParse);
									} catch (NotFormattedExeption e)
									{
										System.out.println("Ex1 main () e = " + e.getRussianMessage());
										break;
									}

								try
									{
										res = Double.parseDouble(toParse[0]);
										res2 = Double.parseDouble(toParse[1]);
										switch (toParse[2])
										{
										case "+":
											System.out.printf("Результат вычисления: %.1f", res + res2);
											break;
										case "-":
											System.out.printf("Результат вычисления: %.1f", res - res2);
											break;
										case "*":
											System.out.printf("Результат вычисления: %.1f", res * res2);
											break;
										case "/":
											try
												{
													System.out.printf("Результат вычисления: %.1f", delim(res, res2));
												} catch (ToNullExeption e)
												{
													System.out.println("Ex1 main () e = " + e.getRussianMessage());
												}
											break;
										default:
											System.out.println("Введена неподдерживаемая математическая операция");
										}
										d = true;
									} catch (NumberFormatException e)
									{
										System.out.println("Ex1 main () e = " + e.getMessage());
										d = false;
										System.out.println("был введен не числовой формат");
									}
							} while (d == false);
					} while (exit == false);

			}

		public static void test(String[] string) throws NotFormattedExeption
			{
				if (string.length != 3)
					throw new NotFormattedExeption();

			}

		public static double delim(Double a, Double b) throws ToNullExeption
			{
				if (b == 0)
					throw new ToNullExeption();
				return a / b;
			}

	}
