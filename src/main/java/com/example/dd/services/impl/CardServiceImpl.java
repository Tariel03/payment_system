package com.example.dd.services.impl;

import com.example.dd.dto.request.CardRequest;
import com.example.dd.dto.response.CardResponse;
import com.example.dd.entities.Business;
import com.example.dd.entities.Card;
import com.example.dd.enums.CardType;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.exceptions.WrongCardType;
import com.example.dd.repos.BusinessRepository;
import com.example.dd.repos.CardRepository;
import com.example.dd.services.repo.BusinessService;
import com.example.dd.services.repo.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    CardRepository cardRepository;
    BusinessServiceImpl businessService;

    @Override
    public void save(CardRequest cardRequest) {
        Card card = Card.builder()
                .number(cardRequest.getNumber())
                .cvc(cardRequest.getCvc())
                .expiration(cardRequest.getExpiration())
                .nameOwner(cardRequest.getNameOwner())
                .build();
        if(cardRequest.getNumber().charAt(0) == '4' &&
        cardRequest.getNumber().charAt(1) == '1'){
            card.setCardType(CardType.VISA);
        }
        else if(cardRequest.getNumber().charAt(0) == 9 &&
                cardRequest.getNumber().charAt(1) == '4'){
            card.setCardType(CardType.VISA);
        }
        else{
            throw new WrongCardType("Wrong card type");
        }

    }

    @Override
    public void save(CardRequest cardRequest, Long id) {
        Card card = Card.builder()
                .number(cardRequest.getNumber())
                .cvc(cardRequest.getCvc())
                .expiration(cardRequest.getExpiration())
                .nameOwner(cardRequest.getNameOwner())
                .build();
        if(cardRequest.getNumber().charAt(0) == '4' &&
                cardRequest.getNumber().charAt(1) == '1'){
            card.setCardType(CardType.VISA);

        }
        else if(cardRequest.getNumber().charAt(0) == 9 &&
                cardRequest.getNumber().charAt(1) == '4'){
            card.setCardType(CardType.VISA);
        }
        else{
            throw new WrongCardType("Wrong card type");
        }
        cardRepository.save(card);
        Business business = businessService.findRawById(id);
        business.setCard(card);
        businessService.save(business);

    }

    @Override
    public CardResponse findById(Long id) {
        Optional<Card> optional = cardRepository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundById("can't find card by this id");
        }
        Card card = optional.get();

        return CardResponse.builder()
                .cvc(card.getCvc())
                .expiration(card.getExpiration())
                .nameOwner(card.getNameOwner())
                .type(card.getCardType())
                .build();
    }

    @Override
    public CardResponse findByNumber(String number) {
        Optional<Card> optional = cardRepository.findByNumber(number);
        if(optional.isEmpty()){
            throw new NotFoundById("can't find card by this id");
        }
        Card card = optional.get();

        return CardResponse.builder()
                .cvc(card.getCvc())
                .expiration(card.getExpiration())
                .nameOwner(card.getNameOwner())
                .type(card.getCardType())
                .build();
    }

    @Override
    public List<CardResponse> findAll() {
        return null;
    }
}
