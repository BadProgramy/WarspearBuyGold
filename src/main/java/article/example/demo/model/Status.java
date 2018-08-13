package article.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public abstract class Status {
    /*ОБРАБОТАН,
    ПРОВЕРЯЕТСЯ_ОПЛАТА,
    ИДЕТ_ВЫСТАВЛЕНИЕ_СЧЕТА*/

    public static final String OBRABOTAN = "ОБРАБОТАН";
    public static final String PROVERYETSY_OPLATA = "ПРОВЕРЯЕТСЯ_ОПЛАТА";
    public static final String IDET_VYSTAVLENIE_SCHETA = "ИДЕТ_ВЫСТАВЛЕНИЕ_СЧЕТА";
}
