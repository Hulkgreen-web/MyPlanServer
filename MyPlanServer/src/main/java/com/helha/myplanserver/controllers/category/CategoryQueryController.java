package com.helha.myplanserver.controllers.category;

import com.helha.myplanserver.application.category.query.CategoryQueryProcessor;
import com.helha.myplanserver.application.category.query.getall.GetAllCategoryOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myplan/categories")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class CategoryQueryController {
    private final CategoryQueryProcessor categoryQueryProcessor;

    public CategoryQueryController(CategoryQueryProcessor categoryQueryProcessor) {
        this.categoryQueryProcessor = categoryQueryProcessor;
    }

    @Operation(summary = "List of all categories")
    @ApiResponse(responseCode = "200")
    @GetMapping()
    public ResponseEntity<GetAllCategoryOutput> getAllCategories() {
        return ResponseEntity.ok(categoryQueryProcessor.getAllCategoryHandler.handle());
    }


}
