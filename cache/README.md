# cache

Generates cache for self-hosted cljs to use on http://quil.info/sketches/create.

## Usage

Run
```shell
lein run -m cache.core/run
```

And copy `core-cache.edn` and `quil-cache.edn` to `public` folder of quil-site.

If you are not familiar with self-hosted cljs - read "Getting started" articles: http://nbeloglazov.com/2016/03/05/getting-started-with-self-hosted-cljs-part-1.html. After which purpose of this tools should be a little bit clearer.

## How it works

This tool performs the following steps:

1. Runs `src/clj/cache/core.clj` which does the following
    1. Compiles `src/cljs/cache/core.cljs` into JS.
    2. Starts static file server that can serve raw Quil source files.
    3. Runs NodeJS on the compiled `core.cljs` file.
2. NodeJS running on the compiled `core.cljs` does the following:
    1. Compiles `quil.core` namespace and stores cache in `caches` atom.
    2. Compiles `quil.sketch` namespace and stores caches in `caches` atom.
    3. Writes quil-related cache in `quil-cache.edn` file and cljs-core related cache to `core-cache.edn`.
