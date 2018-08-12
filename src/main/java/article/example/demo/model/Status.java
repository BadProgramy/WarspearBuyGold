package article.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum Status {
    ОБРАБОТАН,
    ПРОВЕРЯЕТСЯ_ОПЛАТА,
    ИДЕТ_ВЫСТАВЛЕНИЕ_СЧЕТА
}
