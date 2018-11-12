package ${basePackage}.web;
/*import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;*/
import ${basePackage}.tools.R;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller extends AbstractController{
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @GetMapping("/add")
    @PostMapping("/add")
    public R add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return R.ok();
    }

    @GetMapping("/delete")
    @PostMapping("/delete")
    public R delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return R.ok();
    }

    @GetMapping("/update")
    @PostMapping("/update")
    public R update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return R.ok();
    }

    @GetMapping("/detail")
    @PostMapping("/detail")
    public R detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return R.ok().put("data", ${modelNameLowerCamel});
    }

    @GetMapping("/list")
    @PostMapping("/list")
    public R list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return R.ok().put("data", pageInfo);
    }
}
