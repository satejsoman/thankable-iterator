# thankable-iterator
call `thankU()` before calling `next()`

# use
an iterator over a `Collection<E>` that throws an `UnthankedException` if you don't call `thankU()` before calling `next()`
```java
ThankableIterator<Integer> it = ThankableIterator.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
it.thankU()
  .next();
```
the static factory has a method to return a specific implementation based on the `Teacher` instance passed to it (see below)
# teachers

## love
```java
ThankableIterator.of(underlying, Teachers.LOVE);
```
the default, because love should always be the default
## patience
```java
ThankableIterator.of(underlying, Teachers.PATIENCE);
```
if the underlying iterator is blocking, uses `take()` to block until the next element is available. 

note that this technically breaks the contract of `Iterator::next` since `Iterator` instances are eventually-consistent views of the underlying `Collection` (i.e. a blocking `next` implementation is usually a bad thing)
## pain
```java
ThankableIterator.of(underlying, Teachers.PAIN);
```
throws an `UnthankedException` whenever you try to do anything, even thank it. typical.

# acknowledgments 
- ariana grande
- my exes

