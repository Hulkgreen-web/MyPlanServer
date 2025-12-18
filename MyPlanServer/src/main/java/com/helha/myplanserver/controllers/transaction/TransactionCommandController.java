package com.helha.myplanserver.controllers.transaction;

import com.helha.myplanserver.application.transaction.command.TransactionCommandProcessor;
import com.helha.myplanserver.application.transaction.command.create.CreateTransactionInput;
import com.helha.myplanserver.application.transaction.command.create.CreateTrasactionOutput;
import com.helha.myplanserver.application.transaction.command.update.UpdateTransactionHandler;
import com.helha.myplanserver.application.transaction.command.update.UpdateTransactionInput;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/myplan/transactions")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class TransactionCommandController {
    private final TransactionCommandProcessor transactionCommandProcessor;

    public TransactionCommandController(TransactionCommandProcessor transactionCommandProcessor) {
        this.transactionCommandProcessor = transactionCommandProcessor;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    headers = @Header(
                            name = "Location",
                            description = "Location of created resource"
                    )
            ),
            @ApiResponse(responseCode = "400",
                    content = @Content(schema = @Schema(implementation = org.springframework.http.ProblemDetail.class)))
    })
    @PostMapping()
    public ResponseEntity<CreateTrasactionOutput> create(@Valid @RequestBody CreateTransactionInput input){
        CreateTrasactionOutput output = transactionCommandProcessor.createTransactionHandler.handle(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(output.id)
                .toUri();
        return ResponseEntity
                .created(location)
                .body(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400",
                    content = @Content(schema = @Schema(implementation = org.springframework.http.ProblemDetail.class))),
            @ApiResponse(responseCode = "404",
                    content = @Content(schema = @Schema(implementation = org.springframework.http.ProblemDetail.class)))
    })
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateTransactionInput input){
        try {
            transactionCommandProcessor.updateTransactionHandler.handle(input);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Transaction not found");
        }
    }
}
