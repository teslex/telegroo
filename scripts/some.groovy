import groovy.transform.Canonical

def a = ["a", "b", 23]
def b = ["1", "23", 4]
def c = [1, 2, "a"]

println !Collections.disjoint(a, b)
println !Collections.disjoint(a, c)

@Canonical
class MediaObject {
	String object
}

@Canonical
class Media {

	static <T> T with(Class<T> type, T... data) {
		return data[0]
	}
}

static MediaObject object(String object) {
	new MediaObject(object)
}

Media.with(MediaObject, object('some'), object('other'))
Media.with(MediaObject, 'kek')
Media.with(MediaObject, 1)