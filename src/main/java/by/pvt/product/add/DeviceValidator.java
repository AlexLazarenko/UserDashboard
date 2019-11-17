package by.pvt.product.add;

import by.pvt.pojo.Device;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class DeviceValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return Device.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            Device item = (Device) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deviceName", "field.required",
                    "Device name must not be empty");
            if (item.getDeviceName().length() < 3) {
                errors.rejectValue("deviceName", "deviceName.length",
                        "Device name must be more than 3");
            }
       //     if (item.getPrice() == null || item.getPrice() <= 0) {
       //         errors.rejectValue("price", "price.value",
       //                 "Price must be greater zero");
       //     }
        }
    }

