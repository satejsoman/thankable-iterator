# thankable-iterator
call `thankU()` before calling `next()`

# use
returns an iterator over a `Collection<E>` and throws an `UnthankedException` if you don't call `thankU()` before calling `next()`
```java
ThankableIterator<Integer> it = ThankableIterator.of(IntStream.range(1, 10).iterator());
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

note that this technically breaks the contract of `Iterator::next` since `Iterator` instances are eventually-consistent views of the underlying `Collection` (e.g. a blocking `next` implementation is usually a bad thing)
## pain
```java
ThankableIterator.of(underlying, Teachers.PAIN);
```
throws an `UnthankedException` whenever you try to do anything, even thank it. typical.

# acknowledgments 
- ariana grande
- my exes

