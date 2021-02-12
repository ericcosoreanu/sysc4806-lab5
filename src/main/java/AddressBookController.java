import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @GetMapping("/")
    public AddressBook addressBook() {
        return new AddressBook();
    }

    @PostMapping("/")
    public String addressBookSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        model.addAttribute("addressBook", addressBook);
        return "AddressBook";
    }

}