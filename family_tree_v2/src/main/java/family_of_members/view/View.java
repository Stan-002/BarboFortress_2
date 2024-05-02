package family_of_members.view;

// Этот фрагмент кода определяет интерфейс Java с именем View. Этот интерфейс имеет два абстрактных
// метода:
// 1. `void printAnswer(String text)` — этот метод принимает параметр `String` и используется для
// печати ответа или текста.
// 2. `void start()` — этот метод не принимает никаких параметров и используется для запуска некоторых
// функций или процессов.
public interface View {
    void printAnswer(String text);
    void start();
}
