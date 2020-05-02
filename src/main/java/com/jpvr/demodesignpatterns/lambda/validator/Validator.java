package com.jpvr.demodesignpatterns.lambda.validator;

import com.jpvr.demodesignpatterns.lambda.validator.model.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator {

    ValidatorSupplier on(Person p);

    /**
     * Chain validator
     */
    default Validator thenValidate(Predicate<Person> predicate, String errorMessage) {

        return p -> {

            try {
                on(p).validate();

                if ( predicate.test(p) ) {

                    return () -> p;
                } else {

                    return () -> {
                        ValidationException exception = new ValidationException("The object is not valid");
                        exception.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw exception;
                    };
                }
            } catch (ValidationException validationException) {

                if ( predicate.test(p) ) {

                    return () -> { throw validationException; };
                } else {

                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                    return () -> { throw validationException; };
                }
            } // end catch (ValidationException validationException)
        };
    } // end Validator thenValidate(Predicate<Person> predicate, String errorMessage)

    /**
     * Factory method. Implementation of on() method
     */
    static Validator validate(Predicate<Person> predicate, String errorMessage) {

        return p -> {
            if ( predicate.test(p) ) {

                return () -> p;
            } else {

                return () -> {
                    ValidationException exception = new ValidationException("The object is not valid");
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                };

            }
        };
    } // end static Validator validate(Predicate<Person> predicate, String errorMessage)

    interface ValidatorSupplier extends Supplier<Person> {

        default Person validate() {

            return get();
        } // end Person validate()
    } // end inner interface ValidatorSupplier extends Supplier<Person>

    static class ValidationException extends RuntimeException {
        public ValidationException(String errorMessage) {
            super(errorMessage);
        }
    }
} // end interface Validator
