import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import org.koin.dsl.module

class KoinSymbolProcessor: SymbolProcessor {

    private lateinit var codeGenerator: CodeGenerator
    private lateinit var logger: KSPLogger

    private val KOIN_MODULE_NAME = ""

    override fun init(
        options: Map<String, String>,
        kotlinVersion: KotlinVersion,
        codeGenerator: CodeGenerator,
        logger: KSPLogger
    ) {
        this.codeGenerator = codeGenerator
        this.logger = logger
    }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val modules = resolver.getSymbolsWithAnnotation(KOIN_MODULE_NAME)
        modules
            .asSequence()
            .forEach { type ->
                logger.logging("Jossi symbol: $type", type)
            }
    }
}