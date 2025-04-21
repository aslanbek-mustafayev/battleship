# Battleship Game



## How to use

You can directly launch the game with `gradle`:

```bash
gradle run --quiet --console=plain
```

It will download dependencies, build, test and then launch the game.
The `--quiet` and `--console=plain` option will disable gradle output, so you will see only the console game interface and interact with it.

## Development

You can build the project with:

```bash
gradle build
```

It will build and tests this project, if you want to skip tests, run `gradle assemble`.

To run the tests:

```bash
gradle test
```
