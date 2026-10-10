# SauceDemo — Test Scenarios

## 1. Login

| Scenario ID | Test Scenario | Priority |
|---|---|---|
| LOGIN-S01 | Verify login with valid credentials | High |
| LOGIN-S02 | Verify login with an invalid password | High |
| LOGIN-S03 | Verify login with an empty username | High |
| LOGIN-S04 | Verify login with an empty password | High |
| LOGIN-S05 | Verify behavior for a locked-out user | Medium |
| LOGIN-S06 | Verify logout functionality | High |

## 2. Products

| Scenario ID | Test Scenario | Priority |
|---|---|---|
| PROD-S01 | Verify products are displayed after login | High |
| PROD-S02 | Verify product names and prices are displayed | High |
| PROD-S03 | Verify the product count | Medium |
| PROD-S04 | Verify sorting by product name | Medium |
| PROD-S05 | Verify sorting by price | Medium |
| PROD-S06 | Verify adding a product to the cart | High |
| PROD-S07 | Verify removing a product from the inventory page | Medium |

## 3. Cart

| Scenario ID | Test Scenario | Priority |
|---|---|---|
| CART-S01 | Verify a selected product appears in the cart | High |
| CART-S02 | Verify multiple products can be added | High |
| CART-S03 | Verify a product can be removed from the cart | High |
| CART-S04 | Verify the cart item count | Medium |
| CART-S05 | Verify continuing shopping returns to products | Medium |
| CART-S06 | Verify the cart is empty when no products have been added | Medium |

## 4. Checkout

| Scenario ID | Test Scenario | Priority |
|---|---|---|
| CHK-S01 | Verify checkout can be started from the cart | High |
| CHK-S02 | Verify first name is required | High |
| CHK-S03 | Verify last name is required | High |
| CHK-S04 | Verify postal code is required | High |
| CHK-S05 | Verify valid customer information is accepted | High |
| CHK-S06 | Verify checkout order summary | High |
| CHK-S07 | Verify order completion confirmation | High |
| CHK-S08 | Verify checkout can be cancelled | Medium |

## 5. Cross-Browser and Regression

| Scenario ID | Test Scenario | Priority |
|---|---|---|
| REG-S01 | Verify core login workflow in supported browsers | High |
| REG-S02 | Verify cart operations in supported browsers | High |
| REG-S03 | Verify checkout validation in supported browsers | High |
| REG-S04 | Verify the complete automated suite executes through Maven | High |

## Notes

- These are planned scenarios, not claims that every scenario has already been tested.
- Automation status will be tracked separately in the test-case catalogue.
- Scenarios may be revised as test coverage expands.
