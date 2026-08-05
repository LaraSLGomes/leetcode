class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        graph = defaultdict(list)

        for src, dest in invocations:
            graph[src].append(dest)

        visited = set()
        def dfs(node):
            visited.add(node)
            for child in graph[node]:
                if child not in visited:
                    dfs(child)

        dfs(k)
        all_methods = [i for i in range(n)]
        ret = []
        for v1, v2 in invocations:
            if v1 in visited and v2 not in visited or v2 in visited and v1 not in visited:
                return all_methods
        print(visited)
        return list(set(all_methods) - visited)