package com.example.dd.mappers;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.entities.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-01T08:06:28+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (JetBrains s.r.o.)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(TransactionRequest transactionRequest) {
        if ( transactionRequest == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.id( transactionRequest.getId() );
        transaction.numberSender( transactionRequest.getNumberSender() );
        transaction.expirationDate( transactionRequest.getExpirationDate() );
        transaction.business( transactionRequest.getBusiness() );
        transaction.sum( transactionRequest.getSum() );

        return transaction.build();
    }

    @Override
    public TransactionResponse toResponse(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionResponse.TransactionResponseBuilder transactionResponse = TransactionResponse.builder();

        transactionResponse.numberSender( transaction.getNumberSender() );
        transactionResponse.expirationDate( transaction.getExpirationDate() );
        transactionResponse.business( transaction.getBusiness() );
        transactionResponse.sum( transaction.getSum() );
        transactionResponse.status( transaction.getStatus() );
        transactionResponse.createdAt( transaction.getCreatedAt() );

        return transactionResponse.build();
    }

    @Override
    public List<TransactionResponse> listToResponse(List<Transaction> transactionList) {
        if ( transactionList == null ) {
            return null;
        }

        List<TransactionResponse> list = new ArrayList<TransactionResponse>( transactionList.size() );
        for ( Transaction transaction : transactionList ) {
            list.add( toResponse( transaction ) );
        }

        return list;
    }
}
