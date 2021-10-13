package application.services;

import application.models.FunForm;
import org.springframework.stereotype.Service;

@Service
public class FunFormService {

    public String getNameWithText(FunForm funForm) {
        return "A neved " + funForm.getName() + ".";
    }

    public String getAgeWithText(FunForm funForm) {
        return "A korod " + funForm.getAge() + ".";
    }

    public String getFavoriteWithText(FunForm funForm) {
        return "A kedvenc számod " + funForm.getFavoriteNumber() + ". :)";
    }

}
