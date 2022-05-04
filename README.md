# Design-Patterns-Java
Basic Design Patterns written in Java
## Decorator
Decorator consists of several files and testin Main. In this case the prolem given was to create a different Translators.
Each Translator had just some functionality changed so there is no need to create different class for each new Translator.
The basic translator could read at most fixed number ofcharacters and was of type ordinary. We addded a following types:
- Broken - just sends full message
- Smart - it can read hole message in a smaller chunks of fixed size and could read message of length messageSize x numberOfTranslations
- Encrypted - it returns encrypted message using Caesar's code with fixed offset
- Decrypted - it returns decrypted message using Caesar's code with fixed offset
## Iterator
Iterator consists of two custom iterators for two custom vectors:
- RangeVector - user describes first and last element in Constructor and defines length of the vector in RangeIterator constuctor.
- SparseVector - vector consists of length and List of <Integer,Double> pairs where Integer tells about where in the Vector Double value is positioned.
Iterators consist of three methods which allows resetting, getting current value and moving to next element. In the constructor of the RangeVectorIterator user defines on how many segents user wants to separate vector.
Moreover there are two decorators:
- NormaliseIterator - decorated Iterator which normalise the vectors.
- HadamardIterator - decorated Iterator which iterates through Hadamard product of two Vectors
