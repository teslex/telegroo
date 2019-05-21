def a = ["a", "b", 23]
def b = ["1", "23", 4]
def c = [1, 2, "a"]

println !Collections.disjoint(a, b)
println !Collections.disjoint(a, c)