import pygame

hero_rect = pygame.Rect(100, 500, 120, 125)

# 打印出 关于英雄的的原点 尺寸
print("英雄的原点 %d %d" % (hero_rect.x, hero_rect.y))
print("英雄的尺寸 %d %d" % (hero_rect.width, hero_rect.height))
print("%d %d" % hero_rect.size)
