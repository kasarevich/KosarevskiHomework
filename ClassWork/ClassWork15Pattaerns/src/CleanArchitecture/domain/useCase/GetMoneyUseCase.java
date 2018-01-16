package CleanArchitecture.domain.useCase;

import CleanArchitecture.domain.entity.GetMoneyResult;
import CleanArchitecture.domain.entity.Money;
import CleanArchitecture.domain.repositoty.MoneyRepository;

public class GetMoneyUseCase implements UseCase {
    // у одного USECASE ожет быть только один публичный метод, кроме конструкторов и гет сет
    private MoneyRepository moneyRepository;

    public GetMoneyUseCase( MoneyRepository moneyRepository){
        this.moneyRepository = moneyRepository;
    }


    public void execute(Money money, GetMoneyListener resultListener){
        Money currentMoney = moneyRepository.get();

        //Проверяем, достаточно ли денег
        if(currentMoney.getMoney()>=money.getMoney()){

            Money newMoney = new Money();
            newMoney.setMoney(currentMoney.getMoney() - money.getMoney());

            //Сохраняем новое к-во денег
            moneyRepository.save(newMoney);

            //возвращаем в presentation слой
            GetMoneyResult result = new GetMoneyResult();
            resultListener.onResult(result);
        }else {
            //возвращаем ошибку в presentation слой
            resultListener.onError();
        }
    }
    interface GetMoneyListener{
        //возвращаем ошибку в presentation слой
        void onResult(GetMoneyResult getMoneyResult);
        void onError();
    }
}
