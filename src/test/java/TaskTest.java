import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void shouldFindMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(8, "Сходить в магазин");

        boolean expected = true;
        boolean actual = simpleTask.matches("Сходить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(8, "Сходить в магазин");

        boolean expected = false;
        boolean actual = simpleTask.matches("Выгулять");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Дата релиза");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }
}


//
//        Todos todos = new Todos();
//
//        todos.add(simpleTask);
//        todos.add(epic);
//        todos.add(meeting);
//
//        Task[] expected = { simpleTask, epic, meeting};
//        Task[] actual = todos.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//    }
//}