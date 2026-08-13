package versions.v2.application.module;

import versions.v2.presentation.controller.authentication.LoginController;
import versions.v2.presentation.controller.authentication.RegistrationController;
import versions.v2.presentation.controller.banking.*;
import versions.v2.domain.service.*;

/*
=========================================================
Class : PresentationModule

Layer
Application

Responsibility

Creates every presentation controller.

Collaborates With

DomainModule

Creates

Authentication Controllers

Banking Controllers

Navigation Controllers

Design Principle

Single Responsibility Principle

Architectural Role

Presentation Module

Version
2.0
=========================================================
*/

public class PresentationModule {

    // =====================================================
    // Authentication Controllers
    // =====================================================

    private final RegistrationController registrationController;

    private final LoginController loginController;

    // =====================================================
    // Banking Controllers
    // =====================================================

    private final DepositController depositController;

    private final WithdrawController withdrawController;

    private final TransferController transferController;

    private final BalanceController balanceController;

    private final TransactionHistoryController transactionHistoryController;



    public PresentationModule(
            DomainModule domainModule) {

        // =====================================================
        // Cache Services
        // =====================================================

        RegistrationService registrationService =
                domainModule.getRegistrationService();

        LoginService loginService =
                domainModule.getLoginService();

        DepositService depositService =
                domainModule.getDepositService();

        WithdrawService withdrawService =
                domainModule.getWithdrawService();

        TransferService transferService =
                domainModule.getTransferService();

        BalanceService balanceService =
                domainModule.getBalanceService();

        TransactionHistoryService transactionHistoryService =
                domainModule.getTransactionHistoryService();

        // =====================================================
        // Authentication Controllers
        // =====================================================

        registrationController =
                new RegistrationController(
                        registrationService
                );

        loginController =
                new LoginController(
                        loginService
                );

        // =====================================================
        // Banking Controllers
        // =====================================================

        depositController =
                new DepositController(
                        depositService
                );

        withdrawController =
                new WithdrawController(
                        withdrawService
                );

        transferController =
                new TransferController(
                        transferService
                );

        balanceController =
                new BalanceController(
                        balanceService
                );

        transactionHistoryController =
                new TransactionHistoryController(
                        transactionHistoryService
                );

        // =====================================================
        // Navigation Controllers
        // =====================================================



    }

    // =====================================================
    // Authentication Getters
    // =====================================================

    public RegistrationController getRegistrationController() {
        return registrationController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    // =====================================================
    // Banking Getters
    // =====================================================

    public DepositController getDepositController() {
        return depositController;
    }

    public WithdrawController getWithdrawController() {
        return withdrawController;
    }

    public TransferController getTransferController() {
        return transferController;
    }

    public BalanceController getBalanceController() {
        return balanceController;
    }

    public TransactionHistoryController getTransactionHistoryController() {
        return transactionHistoryController;
    }

    // =====================================================
    // Navigation Getters
    // =====================================================



}
