package jpalearn.controller;

import jpalearn.config.UserSession;
import jpalearn.entity.Equipment;
import jpalearn.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("equipment")
@RequiredArgsConstructor
@Slf4j
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping("list/{id}")
    public String list(@PathVariable("id") Integer id,@RequestParam("message")String message, Model model) {
        var equipment = equipmentRepository.findById(id);
        log.info("equipment:{}", equipment.get());
        model.addAttribute("equipment", equipment.get());
        model.addAttribute("message", message);
        return "equipment/equipment";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Equipment form, Model model) {
        log.info("form:{}", form);
        var message = "";
        try {
            equipmentRepository.saveAndFlush(form);
        } catch (ObjectOptimisticLockingFailureException e) {
            message = "他のユーザに更新されたため、再度操作をお願いします。";
        }
        return "redirect:list/" + form.getId() + "?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8);
    }
}
