package com.dareshuri.libralink.Controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.LoanDetail;
import com.dareshuri.libralink.Service.LoanDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/loan-detail")
public class LoanDetailController {
    
    @Autowired
    LoanDetailService loanDetailService;

    // CREATE
    @PostMapping("/add")
    public LoanDetail loanDetail(@RequestBody LoanDetail loanDetail) {
        return loanDetailService.addLoanDetail(loanDetail);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<LoanDetail> getAllLoanDetails() {
        return loanDetailService.getAllLoanDetails();
    }

    @GetMapping("/get-by-id/{loanDetailId}")
    public Optional<LoanDetail> getLoanDetailById(@PathVariable Long loanDetailId) {
        return loanDetailService.getLoanDetailById(loanDetailId);
    }

    @GetMapping("/get-by-userid/{userId}")
    public List<LoanDetail> getLoanDetailByUserId(@PathVariable Long userId) {
        return loanDetailService.getLoanDetailByUserId(userId);
    }
    
    @GetMapping("/get-by-bookid/{bookId}")
    public List<LoanDetail> getLoanDetailByBookId(@PathVariable Long bookId) {
        return loanDetailService.getLoanDetailByBookId(bookId);
    }

    @GetMapping("/get-by-loandate/{loanDate}")
    public List<LoanDetail> getLoanDetailByLoanDate(@PathVariable String loanDate) throws ParseException {
        return loanDetailService.getLoanDetailByLoanDate(loanDate);
    }

    // @GetMapping("/get-by-duedate/{dueDate}")
    // public List<LoanDetail> getLoanDetailByDueDate(@PathVariable String dueDate) throws ParseException {
    //     return loanDetailService.getLoanDetailByDueDate(dueDate);
    // }

    // @GetMapping("/get-by-returndate/{returnDate}")
    // public List<LoanDetail> getLoanDetailByReturnDate(@PathVariable String returnDate) throws ParseException {
    //     return loanDetailService.getLoanDetailByReturnDate(returnDate);
    // }

    // UPDATE
    @PutMapping("/update-bookId-by-id/{loanId}")
    public LoanDetail updateBookIdById(@PathVariable Long loanId, @RequestBody Map<String,String> loanDetailMap) {
        return loanDetailService.updateBookIdById(loanId, loanDetailMap);
    }

    @PutMapping("/update-loanDate-by-id/{loanId}")
    public LoanDetail updateLoanDateById(@PathVariable Long loanId, @RequestBody Map<String,String> loanDetailMap) throws ParseException {
        return loanDetailService.updateLoanDateById(loanId, loanDetailMap);
    }

    @PutMapping("/update-dueDate-by-id/{loanId}")
    public LoanDetail updateDueDateById(@PathVariable Long loanId, @RequestBody Map<String,String> loanDetailMap) throws ParseException {
        return loanDetailService.updateDueDateById(loanId, loanDetailMap);
    }

    @PutMapping("/update-returnDate-by-id/{loanId}")
    public LoanDetail updateReturnDateById(@PathVariable Long loanId, @RequestBody Map<String,String> loanDetailMap) throws ParseException {
        return loanDetailService.updateReturnDateById(loanId, loanDetailMap);
    }

    @PutMapping("/update-status-by-id/{loanId}")
    public LoanDetail updateStatusById(@PathVariable Long loanId, @RequestBody Map<String,String> loanDetailMap) {
        return loanDetailService.updateStatusById(loanId, loanDetailMap);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{loanId}")
    public String deleteLoanDetailById(@PathVariable Long loanId){
        return loanDetailService.deleteLoanDetailById(loanId);
    }
   
}
