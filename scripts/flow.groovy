import groovy.transform.CompileStatic
import io.reactivex.Flowable
import io.reactivex.Single

@CompileStatic
Single make(Flowable<Object> flowable) {
	flowable.flatMap(o -> o)
}