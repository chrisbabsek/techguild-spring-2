package de.babsek.techguildspring2.users

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("gui/users")
@Controller
class UsersGuiController(
    private val usersService: UserService
) {

    @GetMapping
    fun listAll(model: Model): String {
        val users = usersService.findAll()
        model.addAttribute(
            "usersCountText",
            when (val size = users.size) {
                0 -> "no users available"
                1 -> "1 user available"
                else -> "$size users available"
            }
        )

        model.addAttribute("users", users)
        return "users"
    }
}
