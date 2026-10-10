# Requirements Traceability Matrix

## 1. Purpose

This document maps the key SauceDemo application requirements to test scenarios and detailed test cases. It helps track test coverage and identify requirements that still need testing.

## 2. Traceability Matrix

| Requirement ID | Requirement | Scenario ID | Test Case ID | Priority | Coverage Status |
|---|---|---|---|---|---|
| REQ-001 | Users can log in with valid credentials | LOGIN-S01 | LOGIN-001 | High | Automated — verify execution |
| REQ-002 | Invalid login credentials display an error | LOGIN-S02 | LOGIN-002 | High | Automated — verify execution |
| REQ-003 | Login validates required fields | LOGIN-S03, LOGIN-S04 | LOGIN-003, LOGIN-004 | High | Partial |
| REQ-004 | Locked-out users cannot log in | LOGIN-S05 | LOGIN-005 | Medium | Planned |
| REQ-005 | Users can log out | LOGIN-S06 | LOGIN-006 | High | Planned |
| REQ-006 | Products and prices are displayed | PROD-S01, PROD-S02 | PROD-001, PROD-002 | High | Verify implementation |
| REQ-007 | Products can be sorted by name and price | PROD-S04, PROD-S05 | PROD-003, PROD-004 | Medium | Verify implementation |
| REQ-008 | Users can add products to the cart | PROD-S06 | PROD-005 | High | Verify implementation |
| REQ-009 | The cart displays selected products correctly | CART-S01 | CART-001 | High | Verify implementation |
| REQ-010 | Users can remove products from the cart | CART-S03 | CART-002 | High | Verify implementation |
| REQ-011 | Users can proceed to checkout | CHK-S01 | CHK-001 | High | Verify implementation |
| REQ-012 | Checkout validates required information | CHK-S02, CHK-S03, CHK-S04 | CHK-002, CHK-003, CHK-004 | High | Automated — verify execution |
| REQ-013 | Valid checkout information is accepted | CHK-S05 | CHK-005 | High | Planned |
| REQ-014 | Checkout overview displays correct order details and totals | CHK-S06 | CHK-006 | High | Planned |
| REQ-015 | Users can complete an order | CHK-S07 | CHK-007 | High | Planned |
| REQ-016 | The configured test suite can run through Maven | REG-S04 | REG-001 | High | Verify execution |

## 3. Coverage Notes

- **Automated — verify execution:** A corresponding automated test is believed to exist. Confirm its implementation and execution result before reporting it as passing.
- **Partial:** Some parts of the requirement have test coverage, but others remain unimplemented or unverified.
- **Planned:** The test case is identified but still needs implementation.
- **Verify implementation:** Check the current source code and run the relevant tests to confirm coverage.

## 4. Maintenance

Update this matrix whenever requirements, test scenarios, or test cases change. Keep the IDs consistent across this document, `TestScenarios.md`, and `TestCases.xlsx`.

**Note:** This is a project-level traceability matrix based on the current planned scope, not an official SauceDemo requirements specification.
