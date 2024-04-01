package com.example.introspringintegration;

import com.example.introspringintegration.model.StudentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class IntroSpringIntegrationApplication implements CommandLineRunner {

	@Autowired
	private MessageChannel outputChannel;

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random random = new Random();
		StudentMessage[] arr = {
				new StudentMessage("Абрамов Владислав Николаевич", LocalDate.of(2003, 12, 16), random.nextInt(100) + 1),
				new StudentMessage("Анисимова Анна Александровна", LocalDate.of(2003, 5, 21), random.nextInt(100) + 1),
				new StudentMessage("Байдашев Николай Дмитриевич", LocalDate.of(2004, 5, 26), random.nextInt(100) + 1),
				new StudentMessage("Бирюков Артём Максимович", LocalDate.of(2004, 10, 7), random.nextInt(100) + 1),
				new StudentMessage("Вознесенский Даниил Ильич", LocalDate.of(2003, 5, 26), random.nextInt(100) + 1),
				new StudentMessage("Вязов Павел Дмитриевич", LocalDate.of(2004, 4, 29), random.nextInt(100) + 1),
				new StudentMessage("Гафуров Сергей Алексеевич", LocalDate.of(2004, 7, 9), random.nextInt(100) + 1),
				new StudentMessage("Глушан Генрих Константинович", LocalDate.of(2004, 11, 13), random.nextInt(100) + 1),
				new StudentMessage("Гумеров Михаил Александрович", LocalDate.of(2004, 8, 12), random.nextInt(100) + 1),
				new StudentMessage("Десятниченко Кирилл Григорьевич", LocalDate.of(2004, 11, 24), random.nextInt(100) + 1),
				new StudentMessage("Калинин Егор Андреевич", LocalDate.of(2003, 6, 9), random.nextInt(100) + 1),
				new StudentMessage("Климова Екатерина Ивановна", LocalDate.of(2004, 3, 6), random.nextInt(100) + 1),
				new StudentMessage("Кравченко Кирилл Маркович", LocalDate.of(2003, 5, 4), random.nextInt(100) + 1),
				new StudentMessage("Мустафаев Мухаммадали Мухамадиевич", LocalDate.of(2004, 10, 22), random.nextInt(100) + 1),
				new StudentMessage("Новиков Данила Владимирович", LocalDate.of(2003, 6, 10), random.nextInt(100) + 1),
				new StudentMessage("Новиков Марк Янович", LocalDate.of(2004, 4, 26), random.nextInt(100) + 1),
				new StudentMessage("Обухова Анастасия Юрьевна", LocalDate.of(2004, 5, 21), random.nextInt(100) + 1),
				new StudentMessage("Полянский Михаил Вячеславович", LocalDate.of(2003, 2, 20), random.nextInt(100) + 1),
				new StudentMessage("Павленко Алексей Дмитриевич", LocalDate.of(2004, 1, 6), random.nextInt(100) + 1),
				new StudentMessage("Ржебаев Артём Владиславович", LocalDate.of(2003, 9, 29), random.nextInt(100) + 1),
				new StudentMessage("Русаков Назар Мурадович", LocalDate.of(2004, 4, 7), random.nextInt(100) + 1),
				new StudentMessage("Сапожникова Виолетта Олеговна", LocalDate.of(2003, 2, 10), random.nextInt(100) + 1),
				new StudentMessage("Селезнёв Валерий Алексеевич", LocalDate.of(2003, 4, 28), random.nextInt(100) + 1),
				new StudentMessage("Смирнов Иван Сергеевич", LocalDate.of(2003, 6, 16), random.nextInt(100) + 1),
				new StudentMessage("Сучилкина Анастасия Дмитриевна", LocalDate.of(2003, 9, 12), random.nextInt(100) + 1),
				new StudentMessage("Тихонов Владислав Анатольевич", LocalDate.of(2004, 4, 18), random.nextInt(100) + 1),
				new StudentMessage("Толочик Игорь Владимирович", LocalDate.of(2003, 3, 26), random.nextInt(100) + 1),
				new StudentMessage("Уголев Даниил Романович", LocalDate.of(2003, 8, 8), random.nextInt(100) + 1),
				new StudentMessage("Харлашкина Александра Вадимовна", LocalDate.of(2004, 8, 16), random.nextInt(100) + 1),
		};
        for (StudentMessage studentMessage : arr) {
            outputChannel.send(MessageBuilder.withPayload(studentMessage).build());
        }
	}
}
