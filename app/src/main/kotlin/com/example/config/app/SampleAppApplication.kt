package com.example.config.app

import con.example.config.foo.Foo
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class SampleAppApplication {

    @Value("\${config-sample-app}")
    private lateinit var configSampleApp: String

    @Value("\${config-sample-foo}")
    private lateinit var configSampleFoo: String

    fun run() {
        println(configSampleApp)
        println(configSampleFoo)
        println(Foo(1, "n", 2))
    }
}

fun main(args: Array<String>) {
    val ctx = runApplication<SampleAppApplication>(*args)
    val app = ctx.getBean(SampleAppApplication::class.java)
    app.run()
}