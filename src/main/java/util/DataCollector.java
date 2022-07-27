package util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Data collector class. Used for managing user input
 */
public class DataCollector {
    public DataInputModeEnum mode;
    public DataInputSource source;

    public DataCollector(DataInputModeEnum mode, DataInputSource source){
        this.mode = mode;
        this.source = source;
    }

    public DataCollector(DataInputSource i) {
        source = i;
    }

    public Person requestPerson(){
        try{
            String name = collectName();
            LocalDate birthday = collectBirthday();
            Color eyeColor = collectEyeColor();
            Country nationality = collectNationality();
            Location location = collectLocation();
            return new Person(name, birthday, eyeColor, nationality, location);
        } catch (RunOffCommandException e){
            return null;
        } catch (IOException e){
            System.err.println("Ошибка ввода при создании человека");
            return null;
        }
    };

    public StudyGroup requestStudyGroup(){
        try{
            String name = collectName();
            Coordinates coordinates = collectCoordinates();
            int studentsCount = collectStudentsCount();
            long transferredStudents = collectTransferredStudents();
            FormOfEducation formOfEducation = collectFormOfEducation();
            Semester semesterEnum = collectSemesterEnum();
            System.out.println("Админ группы");
            Person groupAdmin = requestPerson();
            return new StudyGroup(name, coordinates, studentsCount, transferredStudents, formOfEducation, semesterEnum, groupAdmin);
        } catch (RunOffCommandException e){
            return null;
        } catch (IOException e){
            System.err.println("Ошибка ввода при создании группы");
            return null;
        }
    }

    private String collectName() throws RunOffCommandException, IOException {
        try {
            System.out.print("Введите имя (Name): ");
            String candidate = source.get();
            if (candidate.isEmpty()){
                throw new IllegalArgumentException("Пустое имя.");
            } else {
                return candidate;
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage() + " Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectName();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении имени");
            }
        }
    }

    private Coordinates collectCoordinates() throws IOException{
        try {
            System.out.print("Введите координату X (Long < 927) (100): ");
            long x = Long.parseLong(source.get());
            if (x > 927){
                throw new IllegalArgumentException("Значение координаты X не может превышать 927.");
            }
            System.out.print("Введите координату Y (Double < 772) (200): ");
            double y = Double.parseDouble(source.get());
            if (y > 772){
                throw new IllegalArgumentException("Значение координаты Y не может превышать 772.");
            }
            return new Coordinates(x, y);
        } catch (IOException | NumberFormatException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectCoordinates();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении координат");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage() + " Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectCoordinates();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении координат");
            }
        }
    }

    private int collectStudentsCount() throws IOException{
        try {
            System.out.print("Введите количество студентов (Integer) (20): ");
            int candidate = Integer.parseInt(source.get());
            if (candidate > 0){
                return candidate;
            } else {
                throw new IllegalArgumentException("Количество студентов должно быть положительным.");
            }
        } catch (IOException | NumberFormatException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectStudentsCount();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении количества студентов");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage() + " Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectStudentsCount();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении количества студентов");
            }
        }
    }

    private long collectTransferredStudents() throws IOException{
        try {
            System.out.print("Введите количество студентов по обмену (Long) (1): ");
            long candidate = Long.parseLong(source.get());
            if (candidate > 0){
                return candidate;
            } else {
                throw new IllegalArgumentException("Количество студентов должно быть положительным.");
            }
        } catch (IOException | NumberFormatException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectTransferredStudents();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении количества студентов по обмену");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage() + " Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectStudentsCount();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении количества студентов");
            }
        }
    }

    private FormOfEducation collectFormOfEducation() throws IOException{
        try {
            String forms = " ";
            for (FormOfEducation form : FormOfEducation.values()) {
                forms += form.toString() + " ";
            }
            System.out.print("Введите форму обучения из доступных (" + forms + "): ");
            String formString = source.get().toUpperCase();
            return FormOfEducation.valueOf(formString);
        } catch (IOException | IllegalArgumentException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectFormOfEducation();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении формы обучения");
            }
        }
    }

    private Semester collectSemesterEnum() throws IOException{
        try {
            String semesters = " ";
            for (Semester semester : Semester.values()) {
                semesters += semester.toString() + " ";
            }
            System.out.print("Введите семестр из доступных (" + semesters + "): ");
            String semesterString = source.get().toUpperCase();
            return Semester.valueOf(semesterString);
        } catch (IOException | IllegalArgumentException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectSemesterEnum();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении семестра");
            }
        }
    }

    private LocalDate collectBirthday() throws IOException{
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            System.out.print("Введите дату рождения в формате 'дд.мм.гггг' (20.01.2004): ");
            String birthdayString = source.get();
            return LocalDate.parse(birthdayString, formatter);
        } catch (IOException | DateTimeParseException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectBirthday();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении даты рождения");
            }
        }
    }
    private Color collectEyeColor() throws IOException{
        try {
            String colors = " ";
            for (Color color : Color.values()) {
                colors += color.toString() + " ";
            }
            System.out.print("Введите цвет глаз из доступных (" + colors + "): ");
            String eyeColorString = source.get().toUpperCase();
            return Color.valueOf(eyeColorString);
        } catch (IOException | IllegalArgumentException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectEyeColor();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении цвета глаз");
            }
        }

    }
    private Country collectNationality() throws IOException{
        try {
            String nationalities = " ";
            for (Country country : Country.values()) {
                nationalities += country.toString() + " ";
            }
            System.out.print("Введите национальность из доступных (" + nationalities + "): ");
            String nationalityString = source.get().toUpperCase();
            return Country.valueOf(nationalityString);
        } catch (IOException | IllegalArgumentException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectNationality();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении национальности");
            }
        }

    }
    private Location collectLocation() throws IOException{
        try {
            System.out.print("Введите координату X (Double) локации (10.0): ");
            Double x = Double.parseDouble(source.get());
            System.out.print("Введите координату Y (Float) локации (10.0): ");
            Float y = Float.parseFloat(source.get());
            System.out.print("Введите координату X (Integer) локации (10): ");
            Integer z = Integer.parseInt(source.get());
            System.out.print("Введите название локации (Saint-Petersburg): ");
            String locationName = source.get();
            return new Location(x, y, z, locationName);
        } catch (IOException | IllegalArgumentException e){
            System.err.println("Некорректный формат данных. Ввести заново? [y/n]");
            if (Objects.equals(source.get(), "y")){
                return collectLocation();
            } else {
                throw new RunOffCommandException("Возникла ошибка при получении локации");
            }
        }
    }
}
