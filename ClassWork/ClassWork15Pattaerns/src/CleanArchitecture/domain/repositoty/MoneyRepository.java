package CleanArchitecture.domain.repositoty;

import CleanArchitecture.domain.entity.Money;
//save, get, update, remove - все, что есть в репозитории
//1 епозиторий хранит 1 единицу entity
public interface MoneyRepository {
    Money get();
    void save(Money money);
}
