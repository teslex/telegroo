import groovy.transform.Canonical
import groovy.transform.ToString

def a = ["a", "b", 23]
def b = ["1", "23", 4]
def c = [1, 2, "a"]

println !Collections.disjoint(a, b)
println !Collections.disjoint(a, c)

@ToString
class MediaObject {

	String object

	MediaObject(@DelegatesTo(MediaObject) Closure closure) {
		closure.delegate = this
		closure()
	}

	MediaObject(String object) {
		this.object = object
	}
}

@Canonical
@Newify([MediaObject])
class Media {

	static some = MediaObject {
		object = 'obj'
	}

	static <T> List<T> with(Class<T> type = MediaObject, T... data) {
		return data
	}

	static <T> T with(Class<T> type = MediaObject, @DelegatesTo(type = "T") Closure closure) {
		T t = type.newInstance()
		closure.delegate = t
		closure()
		t
	}
}

static MediaObject object(String object) {
	new MediaObject(object)
}

Media.with(MediaObject, object('some'), object('other'))
Media.with(object('someThing'))
Media.with(String, 'kek')
Media.with(Number, 1)

println Media.some