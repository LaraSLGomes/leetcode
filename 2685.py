from collections import deque

class Solution:
    def countCompleteComponents(self, n: int, edges: list[list[int]]) -> int:
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * n
        complete_count = 0

        for node in range(n):
            if not visited[node]:
                visited[node] = True
                stack = [node]
                node_count = 0
                edge_count = 0

                while stack:
                    curr = stack.pop()
                    node_count += 1
                    edge_count += len(graph[curr])

                    for neighbor in graph[curr]:
                        if not visited[neighbor]:
                            visited[neighbor] = True
                            stack.append(neighbor)

                if edge_count // 2 == node_count * (node_count - 1) // 2:
                    complete_count += 1

        return complete_count
