package com.helha.myplanserver.controllers.category;

import com.helha.myplanserver.application.category.query.CategoryQueryProcessor;
import com.helha.myplanserver.application.category.query.getall.GetAllCategoryOutput;
import com.helha.myplanserver.application.category.query.getallbyid.GetAllByIdOutput;
import com.helha.myplanserver.application.category.query.getbyid.GetCategoryByIdOutput;
import com.helha.myplanserver.application.subcategory.query.SubCategoryQueryProcessor;
import com.helha.myplanserver.application.subcategory.query.getsubcategorybycatidandsubid.GetSubCategoryByCatIdAndSubIdHandler;
import com.helha.myplanserver.application.subcategory.query.getsubcategorybycatidandsubid.GetSubCategoryByCatIdAndSubIdOuput;
import com.helha.myplanserver.controllers.category.exceptions.CategorynotFoundException;
import com.helha.myplanserver.controllers.subcategory.exception.SubCategoryNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myplan/categories")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class CategoryQueryController {
    private final CategoryQueryProcessor categoryQueryProcessor;
    private final SubCategoryQueryProcessor subCategoryQueryProcessor;

    public CategoryQueryController(CategoryQueryProcessor categoryQueryProcessor, SubCategoryQueryProcessor subCategoryQueryProcessor) {
        this.categoryQueryProcessor = categoryQueryProcessor;
        this.subCategoryQueryProcessor = subCategoryQueryProcessor;
    }

    @Operation(summary = "List of all categories")
    @ApiResponse(responseCode = "200")
    @GetMapping()
    public ResponseEntity<GetAllCategoryOutput> getAllCategories() {
        return ResponseEntity.ok(categoryQueryProcessor.getAllCategoryHandler.handle());
    }

    @Operation(summary = "List of all subcategories")
    @ApiResponse(responseCode = "200")
    @GetMapping("{id}")
    public ResponseEntity<GetAllByIdOutput> getAllSubCategories(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(categoryQueryProcessor.getAllByIdHandler.handle(id));
        } catch (IllegalArgumentException e){
            throw new SubCategoryNotFoundException(id,id);
        }
    }

    @Operation(summary = "Get a category by its id")
    @ApiResponse(responseCode = "200")
    @GetMapping("get/{id}")
    public ResponseEntity<GetCategoryByIdOutput> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryQueryProcessor.getCategoryByIdHandler.handle(id));
        } catch (IllegalArgumentException e) {
            throw new CategorynotFoundException(id);
        }
    }

    @Operation(summary = "Get a subcategory by its id and category id")
    @ApiResponse(responseCode = "200")
    @GetMapping("getSub/{id}/{subId}")
    public ResponseEntity<GetSubCategoryByCatIdAndSubIdOuput> findByCatAndSubId(@PathVariable Long id, @PathVariable Long subId) {
        try {
            return ResponseEntity.ok(subCategoryQueryProcessor.getCategoryByIdHandler.handle(id, subId));
        } catch (IllegalArgumentException e) {
            throw new SubCategoryNotFoundException(id,subId);
        }
    }


}
