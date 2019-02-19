package com.withive.hems.controller

import com.withive.hems.bean.Greeting
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.concurrent.atomic.AtomicLong

@Controller
class HomeControllerKt : ErrorController {

    companion object {
        const val PATH = "/error"
    } 

    override fun getErrorPath(): String {
        return PATH
    }

    private val counter = AtomicLong()
    private val template = "Hello %s"

    @RequestMapping("/kt")
    @ResponseBody
    fun index(): String {
        return "kotlin index"
    }

    @RequestMapping("/kt/greet")
    @ResponseBody
    fun greet(@RequestParam(value = "name", defaultValue = "OSCAR") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), template.format("kotlin $name"))
    }

    @RequestMapping(PATH)
    @ResponseBody
    fun error(): String {
        return "发生内部错误"
    }

}

