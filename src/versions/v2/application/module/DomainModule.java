package versions.v2.application.module;


import versions.v2.domain.factory.UserFactory;
import versions.v2.domain.service.*;
import versions.v2.domain.validator.DepositValidator;
import versions.v2.domain.validator.LoginValidator;
import versions.v2.domain.validator.RegistrationValidator;
import versions.v2.domain.validator.TransferValidator;
import versions.v2.domain.validator.WithdrawValidator;
import versions.v2.repository.UserRepository;

/*
=========================================================
Class : DomainModule

Layer
Application

Responsibility

Creates all business layer components.

Creates

Validators

Factories

Services

Collaborates With

InfrastructureModule

Design Principle

Single Responsibility Principle

Architectural Role

Domain Module

Version
2.0
=========================================================
*/

public class  DomainModule {

    // =====================================================
    // Validators
    // =====================================================

    private final RegistrationValidator registrationValidator;

    private final LoginValidator loginValidator;

    private final DepositValidator depositValidator;

    private final WithdrawValidator withdrawValidator;

    private final TransferValidator transferValidator;

    // =====================================================
    // Factories
    // =====================================================

   private final UserFactory userFactory;

    // =====================================================
    // Services
    // =====================================================

    private final RegistrationService registrationService;

    private final LoginService loginService;

    private final DepositService depositService;

    private final WithdrawService withdrawService;

    private final TransferService transferService;

    private final BalanceService balanceService;

    private final TransactionHistoryService transactionHistoryService;

    public DomainModule(
            InfrastructureModule infrastructureModule) {

        UserRepository userRepository =
                infrastructureModule.getUserRepository();

        // =====================================================
        // Validators
        // =====================================================

        registrationValidator =
                new RegistrationValidator();

        loginValidator =
                new LoginValidator();

        depositValidator =
                new DepositValidator();

        withdrawValidator =
                new WithdrawValidator();

        transferValidator =
                new TransferValidator();

        // =====================================================
        // Factories
        // =====================================================

        userFactory =
                new UserFactory();

        // =====================================================
        // Services
        // =====================================================

        registrationService =
                new RegistrationService(
                        userRepository,
                        registrationValidator,
                        userFactory
                );

        loginService =
                new LoginService(
                        userRepository,
                        loginValidator
                );

        depositService =
                new DepositService(
                        depositValidator
                );

        withdrawService =
                new WithdrawService(
                        withdrawValidator
                );

        transferService =
                new TransferService(
                        userRepository,
                        transferValidator
                );

        balanceService =
                new BalanceService();

        transactionHistoryService =
                new TransactionHistoryService();

    }

    // =====================================================
    // Getters
    // =====================================================

    public RegistrationService getRegistrationService() {

        return registrationService;

    }

    public LoginService getLoginService() {

        return loginService;

    }

    public DepositService getDepositService() {

        return depositService;

    }

    public WithdrawService getWithdrawService() {

        return withdrawService;

    }

    public TransferService getTransferService() {

        return transferService;

    }

    public BalanceService getBalanceService() {

        return balanceService;

    }

    public TransactionHistoryService getTransactionHistoryService() {

        return transactionHistoryService;

    }

}
