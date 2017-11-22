package by.it_academy.task1;


public class Patient {
    private String fio;
    private String diagnos;
    private int age;
    private int room;
    private boolean status;

    public Patient(){               // перегрузка конструктора по-умолчанию
        fio = "Нет данных";
        diagnos = "Не определен";
        age = 0;
        room = 0;
        status = false;
    }

    public Patient(String fio, String diagnos, int age, int room, boolean status) throws Exception{     //пользовательский к-тор, с проверкой корректности значений

        if (fio != null) {
            this.fio = fio;
        }
        else throw new Exception("Неверное имя!");

        if (diagnos != null) {
            this.diagnos = diagnos;
        }
        else throw new Exception("Неверный диагноз!");

        if (age > 0 && age < 110) {
            this.age = age;
        }
        else throw new Exception("Неверный возраст!");

        if (room > 0) {
            this.room = room;
        }
        else throw new Exception("Неверная палата!!");

        this.status = status;

    }

                    public String getFio() {
                        return fio;
                    }

                    public void setFio(String fio) {
                        this.fio = fio;
                    }

                    public String getDiagnos() {
                        return diagnos;
                    }

                    public void setDiagnos(String diagnos) {
                        this.diagnos = diagnos;
                    }

                    public int getAge() {
                        return age;
                    }

                    public void setAge(int age) {
                        this.age = age;
                    }

                    public int getRoom() {
                        return room;
                    }

                    public void setRoom(int room) {
                        this.room = room;
                    }

                    public boolean isStatus() {
                        return status;
                    }

                    public void setStatus(boolean status) {
                        this.status = status;
                    }




        public void printPatient(){    // Вывод всех полей объекта
        String status1 = new String();
        if (status == true){
            status1 = "На лечении";
        }
        else status1 = "Выписан";
            System.out.println("|\t" + fio + "\t|\t" + diagnos + "\t|\t" + age + "\t|\t" + room + "\t|\t" + status1 +"\t|");
        }


}
