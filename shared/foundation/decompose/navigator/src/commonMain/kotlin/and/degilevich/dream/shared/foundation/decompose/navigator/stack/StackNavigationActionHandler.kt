package and.degilevich.dream.shared.foundation.decompose.navigator.stack

interface StackNavigationActionHandler<out StackConfig : Any> {
    fun handle(action: StackNavigationAction<StackConfig>)
}