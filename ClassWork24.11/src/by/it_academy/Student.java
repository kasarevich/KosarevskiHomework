package by.it_academy;

public class Student extends People{

    private String numStutCard;

    public String getNumStutCard() {
        return numStutCard;
    }

    public void setNumStutCard(String numStutCard) {
        this.numStutCard = numStutCard;
    }


    @Override
    public String getName() {
        // if(hgvfgv) {}          - Перегрузка свойств в подклассе, чтобы не изменялась логика суперкласса
        return super.getName();

    }
}
