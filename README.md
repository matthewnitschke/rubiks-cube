# rubiks-cube
Java program that brute force solves a rubik's cube 


# Example

```java
Cube cube = new Cube();
CubeHabdler handler = new CubeHandler(cube);

cube.printCube();
handler.bruteForceFront();
cube.printCube();
```


# API

### Cube

```java
Cube cube = new Cube();

cube.rotateX(0);
cube.rotateY(0);
cube.isSolved();
cube.printCube();
```

### CubeHandler

```java
CubeHandler handler = new CubeHandler(cube);

handler.mix();
handler.bruteForceFront();
handler.bruteForceFull();
```

# Run time

Run times are pretty much random. But for a `bruteForceFront()` call it takes about 3-5seconds. I have only run `bruteForceFull()` once, and it took 53min and 15sec
