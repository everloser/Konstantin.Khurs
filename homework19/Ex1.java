package homework19;

import java.util.ArrayList;
import java.util.List;

/**
 * Использование паттернов проектирования.
 * 
 * Паттерн Composite, Компоновщик - структурный паттерн, структурирующий объекты.
 * Позволяет клиентам единообразно трактовать индивидуальные и составные объекты.
 * Используется также и в итоговом проекте, при заполнении JMenu и JBar
 * 
 * Паттерн Memento, Память - поведенческий паттерн, нужен для хранения определенного состояния объекта.
 * Одно из условий реализации паттерна - при сохранении состояния не должна нарушаться инкапсуляция.
 * И самое главное - должна присутствовать возможность возврата к предыдущему состоянию объекта.
 * @author 
 */
public class Ex1
	{

		public static void main(String[] args)
			{
				Shape square1 = new Square(5);
				Shape square2 = new Square(6);
				Shape square3 = new Square(7);
				Shape rectangle1 = new Rectangle(3, 4);
				Shape rectangle2 = new Rectangle(3, 5);
				Shape rectangle3 = new Rectangle(4, 5);
				Shape triangle1 = new Triangle(3, 4, 5);
				Shape triangle2 = new Triangle(4, 4, 6);
	// Класс Composite реализует паттерн Composite
				Composite compShape = new Composite();
				Composite compShape2 = new Composite();
				Composite compShape3 = new Composite();
	// может хранить как индивидуальные объекты
				compShape2.addShape(square1);
				compShape2.addShape(square2);
				compShape2.addShape(square3);
				compShape2.addShape(triangle1);
				compShape3.addShape(rectangle1);
				compShape3.addShape(rectangle2);
				compShape3.addShape(rectangle3);
				compShape3.addShape(triangle2);
	// так и составные
				compShape.addShape(compShape2);
				compShape.addShape(compShape3);
	// методу findS() также всё равно, индивидуальные или составные объекты находятся в compShape
				compShape.findS();
				
	// Реализация паттерна Memento
				Square square = new Square(5);
				square.findS();
	// вызываем метод playWithSquare(), который создает объект внутреннего класса, запоминающий
	// текущие значения полей объекта внешнего класса
				square.playWithSquare();
	// после чего меняем значение полей объекта
				square.setSsa(6);
				square.findS();
	// отменяем внесенные изменения
				square.undoChangesSquare();
				square.findS();
				
			}
	}

class Composite implements Shape
{
	private List<Shape> shapes = new ArrayList<>();
	public void addShape(Shape shape)
		{ 
			shapes.add(shape);
		}
	public void removeShape(Shape shape)
		{ 
			shapes.remove(shape);
		}
	@Override
	public void findS()
		{
			for(Shape shape : shapes)
				shape.findS();
		}
}
