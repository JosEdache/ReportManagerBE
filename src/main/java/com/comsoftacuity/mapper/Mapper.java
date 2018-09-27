package com.comsoftacuity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.comsoftacuity.dto.AccountTypedto;
import com.comsoftacuity.dto.Accountdto;
import com.comsoftacuity.dto.PaymentLogdto;
import com.comsoftacuity.dto.Suggestiondto;
import com.comsoftacuity.entity.Account;
import com.comsoftacuity.entity.AccountType;
import com.comsoftacuity.entity.PaymentLog;
import com.comsoftacuity.entity.Suggestion;

public class Mapper {

    // from account entity list to accountdto list
    public static List<Accountdto> mapToAccountdtoList(List<Account> mapFrom) {

        if (mapFrom != null) {
            List<Accountdto> accountdtos = new ArrayList<>() ;
            mapFrom.stream().forEach(acct -> accountdtos.add(mapToAccountdto(acct)));
            return accountdtos ;
        }

        return null ;
    }


    
    // from accountdto to account entity
    public static Account mapToAccount(Accountdto mapFrom, AccountType accountType) {
        if (mapFrom != null) {
            Account account = new Account() ;
            account.setId(mapFrom.getId());
            account.setCode(mapFrom.getCode());
            account.setDescription(mapFrom.getDescription());
            account.setBookmarks(mapFrom.getBookmarks());
            account.setAccountType(accountType);
            return account ;
        }
        return null ;
    }

    // from account entity to account dto
    public static Accountdto mapToAccountdto(Account mapFrom) {
        if (mapFrom != null) {
            Accountdto accountdto = new Accountdto() ;
            accountdto.setId(mapFrom.getId());
            accountdto.setCode(mapFrom.getCode());
            accountdto.setDescription(mapFrom.getDescription());
            accountdto.setBookmarks(mapFrom.getBookmarks());
            accountdto.setAccountType(mapFrom.getAccountType());
            return accountdto ;
        }
        return null ;
    }

    // from paymentlog entity list to paymentlogdto list
    public static List<PaymentLogdto> mapToPaymentLogList(List<PaymentLog> mapFrom) {
        if (mapFrom != null) {
           List<PaymentLogdto> paymentLogdtos = new ArrayList<>() ;
           mapFrom.stream().forEach((pl) -> paymentLogdtos.add(mapToPaymentLogdto(pl)));
           return paymentLogdtos ;
        }
        return null ;
    }

    // from paymentlog entity to paymentlogdto
    public static PaymentLogdto mapToPaymentLogdto(PaymentLog mapFrom) {
        if (mapFrom != null) {
            PaymentLogdto paymentLogdto = new PaymentLogdto() ;
            paymentLogdto.setId(mapFrom.getId());
            paymentLogdto.setAccount(mapFrom.getAccount());
            paymentLogdto.setDescription(mapFrom.getDescription());
            paymentLogdto.setPaymentType(mapFrom.getPaymentType());
            paymentLogdto.setDateLog(mapFrom.getDateLog());
            paymentLogdto.setLastModified(mapFrom.getLastModified());
            return paymentLogdto ;
        }
        return null ;
    }

    // from paymentlogdto to paymentlog entity
    public static PaymentLog mapToPaymentLog(PaymentLogdto mapFrom) {
        if (mapFrom != null) {
            PaymentLog paymentLog = new PaymentLog() ;
            paymentLog.setId(mapFrom.getId());
            paymentLog.setAccount(mapFrom.getAccount());
            paymentLog.setDateLog(mapFrom.getDateLog());
            paymentLog.setDescription(mapFrom.getDescription());
            paymentLog.setLastModified(mapFrom.getLastModified());
            return paymentLog ;
        }
        return null ;
    }

    // from accounttype list to accounttype dto list
    public static List<AccountTypedto> mapToAccountTypedtoList(List<AccountType> mapFrom) {
        if (mapFrom != null) {
            List<AccountTypedto> accountTypedtos = new ArrayList<>() ;
            mapFrom.stream().forEach(acctType -> accountTypedtos.add(mapToAccountTypedto(acctType)));
            return accountTypedtos ;
        }
        return null ;
    }


    // from accounttypedto to accounttype entity
    public static AccountType mapToAccountType(AccountTypedto mapFrom) {
        if (mapFrom != null) {
            AccountType accountType = new AccountType() ;
            accountType.setId(mapFrom.getId());
            accountType.setCode(mapFrom.getCode());
            accountType.setDescription(mapFrom.getDescription());
            return accountType ;
        }
        return null ;
    }


    // from accounttyped entity to accounttype dto
    public static AccountTypedto mapToAccountTypedto(AccountType mapFrom) {
        if (mapFrom != null) {
            AccountTypedto accountTypedto = new AccountTypedto() ;
            accountTypedto.setId(mapFrom.getId());
            accountTypedto.setCode(mapFrom.getCode());
            accountTypedto.setDescription(mapFrom.getDescription());
            return accountTypedto ;
        }
        return null ;
    }
    
    // from suggestion entity to suggestion dto
    public static Suggestiondto mapToSuggestiondto(Suggestion mapFrom) {
    	if(mapFrom == null) {
    		return null ;
    	}
    	Suggestiondto suggestiondto = new Suggestiondto() ;
    	suggestiondto.setAutocomplete(mapFrom.getAutocomplete());
    	return suggestiondto ;
    }
    
    public static Suggestion mapToSuggestion(Suggestion mapFrom) {
    	if(mapFrom == null) {
    		return null ;
    	}
    	Suggestion suggestion = new Suggestion() ;
    	suggestion.setAutocomplete(mapFrom.getAutocomplete());
    	return suggestion ;
    }
    
    public static List<Suggestiondto> mapToSuggestiondtoList(List<Suggestion> mapFrom) {
    	if(mapFrom == null) {
    		return null ;
    	}
    	List<Suggestiondto> suggestiondtos = new ArrayList<>();
    	mapFrom.forEach(suggestions -> suggestiondtos.add(mapToSuggestiondto(suggestions)));
    	return suggestiondtos ;
    }
}