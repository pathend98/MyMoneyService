package dev.hend.MyMoneyService.credit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.credit.model.Credit;

@Repository
public interface CreditRepository extends CrudRepository<Credit, UUID> {

    List<Credit> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query(
            value =
                    """
        SELECT * FROM credit
        WHERE date >= :startDate
        AND date <= :endDate
        AND (
            (:paid AND date_of_payment IS NOT NULL)
            OR
            (NOT :paid AND date_of_payment IS NULL)
        )
        """,
            nativeQuery = true)
    List<Credit> findAllByDateBetweenAndPaid(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("paid") Boolean paid);
}
