package com.helha.myplanserver.controllers.transaction;

import com.helha.myplanserver.application.transaction.query.TransactionQueryProcessor;
import com.helha.myplanserver.application.transaction.query.getall.GetAllTransactionOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myplan/transactions")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class TransactionQueryController {
    private final TransactionQueryProcessor transactionQueryProcessor;

    public TransactionQueryController(TransactionQueryProcessor transactionQueryProcessor) {
        this.transactionQueryProcessor = transactionQueryProcessor;
    }

    @Operation(summary = "List of all transactions")
    @ApiResponse(responseCode = "200")
    @GetMapping()
    public ResponseEntity<GetAllTransactionOutput> getAllTransactions(){
        return ResponseEntity.ok(transactionQueryProcessor.getAllTransactionHandler.handle());
    }

}
